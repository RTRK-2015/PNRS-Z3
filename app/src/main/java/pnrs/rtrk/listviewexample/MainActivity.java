package pnrs.rtrk.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        adapter.addAll("Abc", "Def", "Ghi");

        ListView lv = (ListView)findViewById(R.id.listv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView)view;
        Log.d(TAG, tv.getText().toString());

        adapter.remove(adapter.getItem(i));
    }

    ArrayAdapter<String> adapter;
}
