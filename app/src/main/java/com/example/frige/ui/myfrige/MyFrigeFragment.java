package com.example.frige.ui.myfrige;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.frige.R;
import com.example.frige.WebApi.ManagerAll;
import com.example.frige.adapters.FrigeAdapter;
import com.example.frige.databinding.FragmentGalleryBinding;
import com.example.frige.databinding.FragmentMyFrigeBinding;
import com.example.frige.models.CurrentUser;
import com.example.frige.models.FrigeItemModel;
import com.example.frige.ui.gallery.GalleryViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFrigeFragment extends Fragment {

    private FragmentMyFrigeBinding binding;
    private FrigeAdapter frigeAdapter;
    private ListView frigeItemList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMyFrigeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frigeItemList = root.findViewById(R.id.frigeList);
        frigeLoader();

        return root;
    }

    private void frigeLoader() {

        final Call<List<FrigeItemModel>> frigeLoader = ManagerAll.getInstance().loadFrige(CurrentUser.getInstance().getCurrentUserID());
        frigeLoader.enqueue(new Callback<List<FrigeItemModel>>() {
            @Override
            public void onResponse(Call<List<FrigeItemModel>> call, Response<List<FrigeItemModel>> response) {
                List<FrigeItemModel> responseFrige = response.body();
                frigeAdapter = new FrigeAdapter(responseFrige, getActivity().getApplicationContext());
                frigeItemList.setAdapter(frigeAdapter);
            }

            @Override
            public void onFailure(Call<List<FrigeItemModel>> call, Throwable t) {

            }
        });

    }


}