package com.spark.listdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.spark.listdialog.CustomView.CustomBottomDialogView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog dialog1;


    private Dialog customDlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createSingleSelectListDialog();
        createMultiSelectListDialog();
        createCustomDialog();
    }

    public void displayListDialog(View view) {
        Button btn = (Button)view;
        final String[] items = {"aaa", "bbb", "ccc", "ddd"};
        new AlertDialog.Builder(this)
                .setTitle(btn.getText())
                .setIcon(R.drawable.ic_launcher_foreground)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }

    public void displaySingleSelectListDialog(View view) {
        dialog.show();
    }

    private void createSingleSelectListDialog() {
        final String[] items = {"aaa", "bbb", "ccc", "ddd"};
        dialog = new AlertDialog.Builder(this)
                .setTitle("单选对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, i+"", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", null)
                .create();

    }

    /**
     * 展示多选列表Alert
     * @param view
     */
    public void displayMultiSelectListDialog(View view) {
        dialog1.show();
    }

    private void createMultiSelectListDialog() {
        final String[] items = {"aaa", "bbb", "ccc", "ddd"};
        dialog1 = new AlertDialog.Builder(this)
                .setTitle("复选列表对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(items, new boolean[]{false, true, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                })
                .setPositiveButton("确定", null)
                .create();
    }




    private void createCustomDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_custom_bottom_dialog_view, null);
        Button btnOk = view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDlg.dismiss();
            }
        });
        customDlg = new Dialog(this);
        customDlg.setTitle("自定义Dialog");
        customDlg.setContentView(view);
    }

    public void displayCustomDialog(View view) {

        customDlg.show();


//        LayoutInflater flater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view1 = flater.inflate(R.layout.layout_custom_bottom_dialog_view, null);
//
//        PopupWindow window = new PopupWindow(view1, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//
//        window.setFocusable(true);
//
//        window.setAnimationStyle(R.style.BottomDialogAnimation);
//        window.showAtLocation(MainActivity.this.findViewById(R.id.button3), Gravity.BOTTOM, 0, 0);

    }
}
