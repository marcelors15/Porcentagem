package mrs.com.porcent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Porcentagem extends Activity {

    private EditText edtValor1, edtValor2, edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentagem);

        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        edtResult = findViewById(R.id.edtResult);

        edtValor1.requestFocus();
    }

    public void limpar(View v) {
        edtValor1.setText("");
        edtValor2.setText("");
        edtResult.setText("");

        edtValor1.requestFocus();
    }

    public void calcular(View v) {

        if (verificarValores()) {
            float v1 = Float.parseFloat(edtValor1.getText().toString());
            float v2 = Float.parseFloat(edtValor2.getText().toString());
            float result;

            result = v1 / 100 * v2;
            edtResult.setText(new DecimalFormat("##.##").format(result));
        }
    }

    private boolean verificarValores() {

        if (edtValor1.getText().toString().equals("")) {
            Toast.makeText(this, R.string.campo_vazio, Toast.LENGTH_SHORT).show();
            edtValor1.requestFocus();
            return false;
        } else if (edtValor2.getText().toString().equals("")) {
            Toast.makeText(this, R.string.campo_vazio, Toast.LENGTH_SHORT).show();
            edtValor2.requestFocus();
            return false;

        } else if (edtValor1.getText().toString().equals(".")) {
            Toast.makeText(this, R.string.valor_invalido, Toast.LENGTH_SHORT).show();
            edtValor1.requestFocus();
            return false;
        } else if (edtValor2.getText().toString().equals(".")) {
            Toast.makeText(this, R.string.valor_invalido, Toast.LENGTH_SHORT).show();
            edtValor2.requestFocus();
            return false;
        }
        return true;
    }
}
