package com.nemethedgar.newsreader.navigator;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

import com.nemethedgar.data.remote.exception.ApiException;
import com.nemethedgar.data.remote.exception.ConnectivityException;
import com.nemethedgar.newsreader.R;

import io.reactivex.annotations.NonNull;

public class AlertNavigator {

    private final FragmentManager fragmentManager;
    private final Context context;

    public AlertNavigator(@NonNull FragmentManager fragmentManager, @NonNull Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void showErrorFor(@NonNull Throwable throwable) {
        if (throwable instanceof ConnectivityException || throwable instanceof ApiException) {
            showAlert(context.getString(R.string.network_error, throwable.getMessage()));
        }
    }

    public void showAlert(@NonNull String message) {
        new AlertDialog.Builder(context)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle(R.string.error_title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, (dialogInterface, i) -> {

                })
                .show();
    }
}
