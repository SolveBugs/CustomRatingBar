package customviews.com.customratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zq.customratingbarmoudle.CustonRatingbar;

public class MainActivity extends AppCompatActivity {

    private CustonRatingbar cr1, cr2, cr3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cr1 = (CustonRatingbar) findViewById(R.id.cr1);
        cr2 = (CustonRatingbar) findViewById(R.id.cr2);
        cr3 = (CustonRatingbar) findViewById(R.id.cr3);

        cr1.setmLikeCount(5, 2);
        cr2.setmLikeCount(6, 3);
        cr3.setmLikeCount(8, 4);
    }
}
