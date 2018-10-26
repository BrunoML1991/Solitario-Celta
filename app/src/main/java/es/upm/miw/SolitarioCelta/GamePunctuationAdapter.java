package es.upm.miw.SolitarioCelta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GamePunctuationAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<GamePunctuation> punctuations;
    private int resourceId;

    public GamePunctuationAdapter(Context contexto, ArrayList<GamePunctuation> punctuations, int resourceId) {
        super(contexto, resourceId, punctuations);
        this.context = contexto;
        this.punctuations = punctuations;
        this.resourceId = resourceId;
        setNotifyOnChange(true);
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId, null);
        }

        GamePunctuation punctuation = punctuations.get(position);
        if (punctuation != null) {
            TextView tvId = convertView.findViewById(R.id.tvListadoGamePunctuarionId);
            tvId.setText(Integer.toString(punctuation.getId()));

            TextView tvPlayerName = convertView.findViewById(R.id.tvListadoGamePunctuarionPlayerName);
            tvPlayerName.setText(punctuation.getPlayerName());

            TextView tvDateTime = convertView.findViewById(R.id.tvListadoGamePunctuarionDateTime);
            tvDateTime.setText(String.valueOf(punctuation.getDateTime()));

            TextView tvMissingPieces = convertView.findViewById(R.id.tvListadoGamePunctuarionMissingPieces);
            tvMissingPieces.setText(Integer.toString(punctuation.getPieces()));
        }

        return convertView;
    }

}
