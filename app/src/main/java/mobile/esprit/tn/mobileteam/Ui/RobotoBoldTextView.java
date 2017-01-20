package mobile.esprit.tn.mobileteam.Ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import mobile.esprit.tn.mobileteam.Utile.FontUtil;

/**
 * Created by ahlem_daoud on 31/12/2016.
 */

public class RobotoBoldTextView extends TextView {
    public RobotoBoldTextView(Context context) {
        super(context);
        applyCustomFont();
    }

    public RobotoBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont();
    }

    public RobotoBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont();
    }

    private void applyCustomFont() {
        Typeface customFont = FontUtil.getTypeface(FontUtil.ROBOTO_BOLD);
        setTypeface(customFont);
    }
}
