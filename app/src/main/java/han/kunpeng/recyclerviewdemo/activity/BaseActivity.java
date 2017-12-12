package han.kunpeng.recyclerviewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import han.kunpeng.recyclerviewdemo.R;
import timber.log.Timber;

/**
 * BaseActivity
 *
 * @author William Han
 * @date 2017/12/12
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Timber.d("[onCreate] END");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("[onPostCreate] BEGIN");
        super.onPostCreate(savedInstanceState);
        Timber.d("[onPostCreate] END");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Timber.d("[onAttachFragment] BEGIN");
        super.onAttachFragment(fragment);
        Timber.d("[onAttachFragment] END");
    }

    @Override
    protected void onStart() {
        Timber.d("[onStart] BEGIN");
        super.onStart();
        Timber.d("[onStart] END");
    }

    @Override
    protected void onResume() {
        Timber.d("[onResume] BEGIN");
        super.onResume();
        Timber.d("[onResume] END");
    }

    @Override
    public void onAttachedToWindow() {
        Timber.d("[onAttachedToWindow] BEGIN");
        super.onAttachedToWindow();
        Timber.d("[onAttachedToWindow] END");
    }

    @Override
    protected void onPostResume() {
        Timber.d("[onPostResume] BEGIN");
        super.onPostResume();
        Timber.d("[onPostResume] END");
    }

    @Override
    protected void onPause() {
        Timber.d("[onPause] BEGIN");
        super.onPause();
        Timber.d("[onPause] END");
    }

    @Override
    protected void onRestart() {
        Timber.d("[onRestart] BEGIN");
        super.onRestart();
        Timber.d("[onRestart] END");
    }

    @Override
    protected void onStop() {
        Timber.d("[onStop] BEGIN");
        super.onStop();
        Timber.d("[onStop] END");
    }

    @Override
    protected void onDestroy() {
        Timber.d("[onDestroy] BEGIN");
        super.onDestroy();
        Timber.d("[onDestroy] END");
    }

}
