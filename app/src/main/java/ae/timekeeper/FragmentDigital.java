package ae.timekeeper;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmentDigital.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentDigital extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public FragmentDigital() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_digital, container, false);
    }

}
