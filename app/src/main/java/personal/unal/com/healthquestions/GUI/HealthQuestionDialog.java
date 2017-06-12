package personal.unal.com.healthquestions.GUI;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import personal.unal.com.healthquestions.R;


/**
 * Created by JuanCamilo on 15/10/2016.
 */

public class HealthQuestionDialog extends Dialog {

    public static final int SELECTION_POSITIVE = 1, SELECTION_NEGATIVE = 2;
    private TextView header;
    private TextView content;
    private ImageView icon;
    private Button okButton;
    private Button cancelButton;
    private int selection;

    public HealthQuestionDialog(Context context, int iconID, String headerText,
                                String contentText, String okButtonText,
                                String cancelButtonText, int themeId) {
        super(context, themeId);

        this.setContentView(R.layout.dialog_layout_two_options);
        content = (TextView) this.findViewById(R.id.content);
        icon = (ImageView) this.findViewById(R.id.icon);
        okButton = (Button) this.findViewById(R.id.ok_button);
        content.setText(contentText);
        icon.setImageResource(iconID);
        okButton.setText(okButtonText);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HealthQuestionDialog.this.selection = SELECTION_POSITIVE;
                HealthQuestionDialog.this.dismiss();
            }
        });
        header = (TextView) this.findViewById(R.id.header);
        if (headerText == null || headerText.isEmpty()) {
            header.setVisibility(View.GONE);
        } else {
            header.setText(headerText);
        }
        cancelButton = (Button) this.findViewById(R.id.cancel_button);
        cancelButton.setText(cancelButtonText);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HealthQuestionDialog.this.selection = SELECTION_NEGATIVE;
                HealthQuestionDialog.this.cancel();
            }
        });
    }

    public int getSelection() {
        return selection;
    }

}
