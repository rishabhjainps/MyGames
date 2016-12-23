package hell.mygames;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MemoryGame extends ActionBarActivity {

    TextView highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        highScore = (TextView)findViewById(R.id.highScore);

        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        int score=shared.getInt(getString(R.string.scoreMemoryGame),0);
        highScore.setText("HighScore : "+score);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memory_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        int score=shared.getInt(getString(R.string.scoreMemoryGame),0);
        highScore.setText("HighScore : "+score);
    }


    public void play(View view) {
        Intent intent = new Intent(this,playMemoryGame.class);
        startActivity(intent);
        finish();
    }
}
