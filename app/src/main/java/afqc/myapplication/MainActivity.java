package afqc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    //declaramos las variables

    private BottomSheetBehavior mBottomSheetBehavior;

    private TextView mTextViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //iniciamos las variables enlazar con su id correspondiente

        // se enlaza con el NestedScrollview
        View bottomSheet = findViewById(R.id.bottom_sheet);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mTextViewState = findViewById(R.id.text_view_state);


        //SE enlaza con los botones
        Button buttonExpand = findViewById(R.id.button_expand);
        Button buttonCollapse = findViewById(R.id.button_collapse);


        //Se lo implementa el onclick al boton expandir (opcional se puede quitar)

        buttonExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        //Se lo implementa el onclick al boton collapse

        buttonCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

       //llamamos al bottom sheet para colocar los estados En que estado se encuentra
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mTextViewState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        mTextViewState.setText("Dragging...");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mTextViewState.setText("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        mTextViewState.setText("Hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        mTextViewState.setText("Settling...");
                        break;
                }
            }

            //Estado del deslizamiento
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                mTextViewState.setText("Sliding...");
            }
        });
    }
}