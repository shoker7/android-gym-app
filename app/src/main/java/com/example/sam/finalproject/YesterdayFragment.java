package com.example.sam.finalproject;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
    import com.example.sam.finalproject.R;

/**
 * Created by Sam on 11/25/16.
 */

public class YesterdayFragment extends Fragment{
    public YesterdayFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_yesterday,container, false);
    }
}
