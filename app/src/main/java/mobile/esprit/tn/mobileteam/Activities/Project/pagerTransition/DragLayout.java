package mobile.esprit.tn.mobileteam.Activities.Project.pagerTransition;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import mobile.esprit.tn.mobileteam.R;

/**
 * Essayez de considérer l'ensemble de la version du système d'exploitation de la résolution adaptation
 */
public class DragLayout extends FrameLayout {

    private static final int DECELERATE_THRESHOLD = 120;
    private static final int DRAG_SWITCH_DISTANCE_THRESHOLD = 100;
    private static final int DRAG_SWITCH_VEL_THRESHOLD = 800;
    private static final float MIN_SCALE_RATIO = 0.5f;
    private static final float MAX_SCALE_RATIO = 1.0f;
    private static final int STATE_CLOSE = 1;
    private static final int STATE_EXPANDED = 2;
    private final ViewDragHelper mDragHelper;
    private final GestureDetectorCompat moveDetector;
    private int bottomDragVisibleHeight; // Faites glisser la hauteur visible
    private int bototmExtraIndicatorHeight; // Indicateur de hauteur Bottom
    private int dragTopDest = 0; // La position cible du plateau coulissant
    private int downState; // État lorsqu'il est pressé
    private int mTouchSlop = 5; // Seuil de glissement est déterminée en pixels
    private int originX, originY; // L'état initial，topView Coordonnées
    private View bottomView, topView; // FrameLayout Deux sous View

    private GotoDetailListener gotoDetailListener;

    // <viewDragHelper initialisation>
    public DragLayout(Context context) {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.app, 0, 0);
        bottomDragVisibleHeight = (int) a.getDimension(R.styleable.app_bottomDragVisibleHeight, 0);
        bototmExtraIndicatorHeight = (int) a.getDimension(R.styleable.app_bototmExtraIndicatorHeight, 0);
        a.recycle();
// 10F is related to the sensitivity of the drag 1.0f is normal
        mDragHelper = ViewDragHelper
                .create(this, 10f, new DragHelperCallback());
        mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_TOP);
        moveDetector = new GestureDetectorCompat(context, new MoveDetector());
        moveDetector.setIsLongpressEnabled(false); // Non long événement de presse

        // Coulissante seuil de distance fournie par le système

        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
    }
    // </viewDragHelper initialisation>

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        bottomView = getChildAt(0);
        topView = getChildAt(1);

        topView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cliquez rappel
                int state = getCurrentState();
                if (state == STATE_CLOSE) {
                    // Cliquez lorsque l'état initial, la nécessité d'élargir
                    if (mDragHelper.smoothSlideViewTo(topView, originX, dragTopDest)) {
                        ViewCompat.postInvalidateOnAnimation(DragLayout.this);
                    }
                } else {
                    // Cliquez sur l'état lorsqu'il est déployé, un accès direct à la page de détails
                    gotoDetailActivity();
                }
            }
        });
    }

    // Aller à la page suivante
    private void gotoDetailActivity() {
        if (null != gotoDetailListener) {
            gotoDetailListener.gotoDetail();
        }
    }

    private void postResetPosition() {
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                topView.offsetTopAndBottom(dragTopDest - topView.getTop());
            }
        }, 500);
    }

    /**
     * haut ImageView Changer de lieu，La nécessité d'une partie inférieureview Affichage Zoom
     */
    private void processLinkageView() {
        if (topView.getTop() > originY) {
            bottomView.setAlpha(0);
        } else {
            float alpha = (originY - topView.getTop()) * 0.01f;
            if (alpha > 1) {
                alpha = 1;
            }
            bottomView.setAlpha(alpha);
            int maxDistance = originY - dragTopDest;
            int currentDistance = topView.getTop() - dragTopDest;
            float scaleRatio = 1;
            float distanceRatio = (float) currentDistance / maxDistance;
            if (currentDistance > 0) {
                scaleRatio = MIN_SCALE_RATIO + (MAX_SCALE_RATIO - MIN_SCALE_RATIO) * (1 - distanceRatio);
            }
            bottomView.setScaleX(scaleRatio);
            bottomView.setScaleY(scaleRatio);
        }
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /**
     * Obtenez le statut actuel
     */
    private int getCurrentState() {
        int state;
        if (Math.abs(topView.getTop() - dragTopDest) <= mTouchSlop) {
            state = STATE_EXPANDED;
        } else {
            state = STATE_CLOSE;
        }
        return state;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!changed) {
            return;
        }

        super.onLayout(changed, left, top, right, bottom);

        originX = (int) topView.getX();
        originY = (int) topView.getY();
        dragTopDest = bottomView.getBottom() - bottomDragVisibleHeight - topView.getMeasuredHeight();
    }

    /* touch INTERCEPT et gérer les événements sont remis mDraghelper Pour faire face à */
// related to the DragHelper
    // method is called whenever a touch event is detected
    // on the surface of a ViewGroup, including on the surface of its children
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 1. detector mDragHelper et Déterminer si la nécessité d'intercepter
        boolean yScroll = moveDetector.onTouchEvent(ev);
        boolean shouldIntercept = false;
        try {
            //shouldInterceptTouchEvent 3ibara metakas ya parent t7eb enti thandli l'event?
            shouldIntercept = mDragHelper.shouldInterceptTouchEvent(ev);
        } catch (Exception e) {
        }

        // 2. Directement à des contacts lorsqu'il est pressé mDragHelper
        int action = ev.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            downState = getCurrentState();
            mDragHelper.processTouchEvent(ev);
        }
// voila taw metakdin eli n7ebou el parent eli yhandli l'event mouch child fiwest el view
        return shouldIntercept && yScroll;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // bottomMarginTop Calcul de la hauteur, ou la nécessité d'avoir un modèle mathématique peut clairement.
        // Pour obtenir l'effet, il est topView.top和bottomView.bottom Avant le départ, à la fois centre global et élargi
        int bottomMarginTop = (bottomDragVisibleHeight + topView.getMeasuredHeight() / 2 - bottomView.getMeasuredHeight() / 2) / 2 - bototmExtraIndicatorHeight;
        FrameLayout.LayoutParams lp1 = (LayoutParams) bottomView.getLayoutParams();
        lp1.setMargins(0, bottomMarginTop, 0, 0);
        bottomView.setLayoutParams(lp1);
    }

    // related to the DragHelper
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //Unity mDragHelper processus，由DragHelperCallback Faites glisser les effets pour atteindre
        try {
            mDragHelper.processTouchEvent(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public void setGotoDetailListener(GotoDetailListener gotoDetailListener) {
        this.gotoDetailListener = gotoDetailListener;
    }

    public interface GotoDetailListener {
        void gotoDetail();
    }

    // tghe behaviour of the hole dragging process , hna bech nspecifiw kifech n7ebou e drag ysir
    //men weyn lweyn .....
    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            if (changedView == topView) {
                processLinkageView();
            }
        }

        // method that asks as if there any child in the view that needs to be dragged
//which gives draghelper the permission to drag layout). You must return true up there for the view you want to be dragged.
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == topView;
        }

        //which do what you expect them to do, setting limit for the dragging. In this particular case, vertical range is set to half the size of screen.
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            int currentTop = child.getTop();
            if (top > child.getTop()) {
                // Déroulez le temps, de moindre résistance
                return currentTop + (top - currentTop) / 2;
            }

            int result;
            if (currentTop > DECELERATE_THRESHOLD * 3) {
                result = currentTop + (top - currentTop) / 2;
            } else if (currentTop > DECELERATE_THRESHOLD * 2) {
                result = currentTop + (top - currentTop) / 4;
            } else if (currentTop > 0) {
                result = currentTop + (top - currentTop) / 8;
            } else if (currentTop > -DECELERATE_THRESHOLD) {
                result = currentTop + (top - currentTop) / 16;
            } else if (currentTop > -DECELERATE_THRESHOLD * 2) {
                result = currentTop + (top - currentTop) / 32;
            } else if (currentTop > -DECELERATE_THRESHOLD * 3) {
                result = currentTop + (top - currentTop) / 48;
            } else {
                result = currentTop + (top - currentTop) / 64;
            }
            return result;
        }

        // to allow horizontal drag and to bound the drag motion
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return child.getLeft();
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return 600;
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return 600;
        }

        //is where you (might) want to let the view go into its rest place
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            int finalY = originY;
            if (downState == STATE_CLOSE) {
                // Pressé, Etat: Etat initial
                if (originY - releasedChild.getTop() > DRAG_SWITCH_DISTANCE_THRESHOLD || yvel < -DRAG_SWITCH_VEL_THRESHOLD) {
                    finalY = dragTopDest;
                }
            } else {
                // Pressé, Etat: état déployé
                boolean gotoBottom = releasedChild.getTop() - dragTopDest > DRAG_SWITCH_DISTANCE_THRESHOLD || yvel > DRAG_SWITCH_VEL_THRESHOLD;
                if (!gotoBottom) {
                    finalY = dragTopDest;

                    // Si la presse a commencé, et faites glisser vers le haut, puis entrez les détails Page
                    if (dragTopDest - releasedChild.getTop() > mTouchSlop) {
                        gotoDetailActivity();
                        postResetPosition();
                        return;
                    }
                }
            }

            if (mDragHelper.smoothSlideViewTo(releasedChild, originX, finalY)) {
                ViewCompat.postInvalidateOnAnimation(DragLayout.this);
            }
        }
    }

    class MoveDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float dx,
                                float dy) {
            // Faites glisser le，touch Non transmis
            return Math.abs(dy) + Math.abs(dx) > mTouchSlop;
        }
    }
}
