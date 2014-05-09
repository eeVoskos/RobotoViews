package com.eevoskos.robotoviews;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;

/**
 * 
 * @author Stratos Theodorou
 * 
 */
public class Roboto implements RobotoValues {

    // Debug mode flag
    private static final boolean DEBUG = false;
    
    // TAG for logging
    private static final String TAG = "Roboto";

    // Singleton instance
    private static Roboto ROBOTO;

    // Application context used for parsing app resources
    private Context mContext;

    // Sparse array that holds all lazily instantiated typefaces
    private final static SparseArray<Typeface> mTypefaces = new SparseArray<Typeface>(16);

    private Roboto(Context context) {
        this.mContext = context;
    }

    public static void initialize(Context context) {
        if (ROBOTO == null) {
            ROBOTO = new Roboto(context);
        }
    }

    public static Roboto getInstance() {
        if (ROBOTO == null) {
            throw new IllegalStateException(
                    "You must call Roboto.initialize() first, or call Roboto.getInstance() using Context parameter.");
        }
        return ROBOTO;
    }

    public static Roboto getInstance(Context context) {
        if (ROBOTO == null) {
            ROBOTO = new Roboto(context);
        }
        return ROBOTO;
    }

    /**
     * Returns the appropriate Roboto {@code Typeface} based on the input xml
     * value. If the typeface exists in the internal array, it is returned
     * immediately. Else, it is lazily created and returned. The lazily created
     * typeface is kept for future use.
     * 
     * @param value
     *            The typeface xml value.
     * @return The appropriate Roboto {@code Typeface}.
     */
    public Typeface getTypeface(int value) {
        if (DEBUG) {
            Log.d(TAG, "Getting Typeface for value " + value);
        }
        
        Typeface tf = mTypefaces.get(value);
        if (tf != null) {
            if (DEBUG) {
                Log.i(TAG, "Typeface was loaded from memory.");
            }
            return tf;
        }
        
        int resourceId = getResourceId(value);
        tf = getFontFromRes(resourceId);
        mTypefaces.put(value, tf);

        if (DEBUG) {
            Log.i(TAG, "Typeface was lazily created.");
        }
        
        return tf;
    }

    private int getResourceId(int id) {
        if (id == ROBOTO_REGULAR) {
            return R.raw.roboto_regular;
        } else if (id == ROBOTO_BOLD) {
            return R.raw.roboto_bold;
        } else if (id == ROBOTO_ITALIC) {
            return R.raw.roboto_italic;
        } else if (id == ROBOTO_BOLD_ITALIC) {
            return R.raw.roboto_bold_italic;
        } else if (id == ROBOTO_BLACK) {
            return R.raw.roboto_black;
        } else if (id == ROBOTO_BLACK_ITALIC) {
            return R.raw.roboto_black_italic;
        } else if (id == ROBOTO_CONDENSED) {
            return R.raw.roboto_condensed;
        } else if (id == ROBOTO_CONDENSED_BOLD) {
            return R.raw.roboto_condensed_bold;
        } else if (id == ROBOTO_CONDENSED_ITALIC) {
            return R.raw.roboto_condensed_italic;
        } else if (id == ROBOTO_CONDENSED_BOLD_ITALIC) {
            return R.raw.roboto_condensed_bold_italic;
        } else if (id == ROBOTO_LIGHT) {
            return R.raw.roboto_light;
        } else if (id == ROBOTO_LIGHT_ITALIC) {
            return R.raw.roboto_light_italic;
        } else if (id == ROBOTO_MEDIUM) {
            return R.raw.roboto_medium;
        } else if (id == ROBOTO_MEDIUM_ITALIC) {
            return R.raw.roboto_medium_italic;
        } else if (id == ROBOTO_THIN) {
            return R.raw.roboto_thin;
        } else if (id == ROBOTO_THIN_ITALIC) {
            return R.raw.roboto_thin_italic;
        } else if (id == ROBOTO_SLAB_REGULAR) {
            return R.raw.roboto_slab_regular;
        } else if (id == ROBOTO_SLAB_BOLD) {
            return R.raw.roboto_slab_bold;
        } else if (id == ROBOTO_SLAB_LIGHT) {
            return R.raw.roboto_slab_light;
        } else if (id == ROBOTO_SLAB_THIN) {
            return R.raw.roboto_slab_thin;
        }
        return R.raw.roboto_regular;
    }

    private Typeface getFontFromRes(int resource) {
        Typeface tf = null;
        InputStream is;
        try {
            is = mContext.getResources().openRawResource(resource);
        } catch (NotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return Typeface.DEFAULT;
        }

        String outPath = mContext.getCacheDir() + "/tmp.raw";

        try {
            byte[] buffer = new byte[is.available()];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));

            int l = 0;
            while ((l = is.read(buffer)) > 0)
                bos.write(buffer, 0, l);

            bos.close();

            tf = Typeface.createFromFile(outPath);

            // clean up
            new File(outPath).delete();
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            // Fallback to default font
            return Typeface.DEFAULT;
        }

        return tf;
    }

}
