package com.example.huijunlin.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentNewsMain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentNewsMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNewsMain extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<NewsSectionData> newsSectionDatalist;
    private NewsData newsData;

    public FragmentNewsMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentNewsMain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNewsMain newInstance() {
        FragmentNewsMain fragment = new FragmentNewsMain();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(getActivity());
        newsData = new NewsData("type");
        newsSectionDatalist = new ArrayList<>();
        setRetainInstance(true);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_news_main, container, false);

        NewsSectionData teams = new NewsSectionData("Teams", "Teams");
        NewsSectionData players = new NewsSectionData("Players", "Players");
        NewsSectionData others = new NewsSectionData("Others", "Others");

        newsSectionDatalist.add(teams);
        newsSectionDatalist.add(players);
        newsSectionDatalist.add(others);

        RecyclerView newsRecyclerView = (RecyclerView) view.findViewById(R.id.newslist_recycler_view);
        newsRecyclerView.setHasFixedSize(true);
        NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(getContext(), newsSectionDatalist);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        newsRecyclerView.setAdapter(adapter);




//        myRecyclerViewAdapter.setOnItemClickListener(new SmallNewsFirebaseRecylerAdapter.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(View view, final int position) {
//                //load a new fragment
//                HashMap<String, ?> news = (HashMap<String, ?>) newsData.getItem(position);
//                String id = (String) news.get("NewsID");
//
//                Firebase ref = newsData.getFirebaseRef();
//                ref.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        HashMap<String, String> news = (HashMap<String, String>) dataSnapshot.getValue();
//                        mListener.onListItemSelected(position, news);
//                    }
//
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//                        Log.d("MyTest", "The read failed: " + firebaseError.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onOverflowMenuClick(View view, int position) {
//
//            }
//        });



        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListItemSelected(int position, HashMap<String, String> movie);
    }
}
