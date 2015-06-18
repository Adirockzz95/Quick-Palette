package adik.colorpalette;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import adik.fabtransitions.OtherLibs.animation.SupportAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import adik.fabtransitions.OtherLibs.animation.ViewAnimationUtils;
import adik.fabtransitions.OtherLibs.animation.arcanimator.ArcAnimator;
import adik.fabtransitions.OtherLibs.animation.arcanimator.Side;
import at.markushi.ui.RevealColorView;


public class MainActivity extends ActionBarActivity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    View panel;
   RevealColorView revealColorView;
   SupportAnimator animator;
   ArcAnimator anim;
    float X,Y;
    int[] loc = {0, 0};
    String[] clrs = new String[5];
  float rad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revealColorView = (RevealColorView) findViewById(R.id.reveal); 
        panel = findViewById(R.id.panel);  							
        panel.getLocationInWindow(loc);


		
        final FloatingActionButton fab = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_brush_white_24dp))
                .withGravity(Gravity.BOTTOM|Gravity.END)
                .withMargins(0,0,16,16)
                .withButtonColor(Color.parseColor("#0091EA"))
                .create();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                anim.start();
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        fab.hideFloatingActionButton();
                        panel.setVisibility(View.VISIBLE);
                        animator.start();


                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


            }
        });

          panel.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
              @Override
              public boolean onPreDraw() {
                  X = (panel.getLeft() +panel.getRight())/2;
                  Y = (panel.getTop()+panel.getBottom())/2;
                  rad = Math.max(panel.getWidth(), panel.getHeight());
                  anim = ArcAnimator.createArcAnimator(fab,X,Y,-5, Side.RIGHT);
                  anim.setInterpolator(new AccelerateInterpolator());
                  anim.setDuration(150);
                  anim.setStartDelay(100);
                  animator = ViewAnimationUtils.createCircularReveal(panel, (int)X, (int)Y, 0, rad);
                  animator.setDuration(400);
                  animator.setInterpolator(new AccelerateDecelerateInterpolator());
                  return true;
              }
          });



        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);

        img1.getDrawable().setColorFilter(Color.parseColor("#673AB7"), PorterDuff.Mode.SRC);
        clrs[0] = "#673AB7";
        img1.setTag(clrs[0]);

        img2.getDrawable().setColorFilter(Color.parseColor("#E91E63"), PorterDuff.Mode.SRC);
        clrs[1] = "#E91E63";
        img2.setTag(clrs[1]);

        img3.getDrawable().setColorFilter(Color.parseColor("#9C27B0"), PorterDuff.Mode.SRC);
        clrs[2] = "#9C27B0";
        img3.setTag(clrs[2]);

        img4.getDrawable().setColorFilter(Color.parseColor("#03A9F4"), PorterDuff.Mode.SRC);
        clrs[3] = "#03A9F4";
        img4.setTag(clrs[3]);

        img5.getDrawable().setColorFilter(Color.parseColor("#009688"), PorterDuff.Mode.SRC);
        clrs[4] = "#009688";
        img5.setTag(clrs[4]);


    }

    public void Img1(View v){
        v.getLocationInWindow(loc);
        String parse = (String)v.getTag();
        int color = Color.parseColor(parse);
        revealColorView.reveal(loc[0],loc[1],color,null);

    }
    public void Img2(View v){
        v.getLocationInWindow(loc);
        String parse = (String)v.getTag();
        int color = Color.parseColor(parse);
        revealColorView.reveal(loc[0],loc[1],color,null);


    }
    public void Img3(View v){
        v.getLocationInWindow(loc);
        String parse = (String)v.getTag();
        int color = Color.parseColor(parse);
        revealColorView.reveal(loc[0],loc[1],color,null);


    }
    public void Img4(View v){
        v.getLocationInWindow(loc);
        String parse = (String)v.getTag();
        int color = Color.parseColor(parse);
        revealColorView.reveal(loc[0],loc[1],color,null);


    }
    public void Img5(View v){
        v.getLocationInWindow(loc);
        String parse = (String)v.getTag();
        int color = Color.parseColor(parse);
        revealColorView.reveal(loc[0],loc[1],color,null);

    }


}



