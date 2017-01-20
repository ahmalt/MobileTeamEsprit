package mobile.esprit.tn.mobileteam.Ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import mobile.esprit.tn.mobileteam.Utile.FontUtil;

/**
 * Created by ahlem_daoud on 31/12/2016.
 */

public class RobotoRegularTextView extends TextView {
    public RobotoRegularTextView(Context context) {
        super(context);
        applyCustomFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont();
    }

    private void applyCustomFont() {
        Typeface customFont = FontUtil.getTypeface(FontUtil.ROBOTO_REGULAR);
        setTypeface(customFont);
    }
}
