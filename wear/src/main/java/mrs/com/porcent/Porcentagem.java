package mrs.com.porcent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Porcentagem extends Activity {

    private EditText edtValor1, edtValor2, edtResult;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentagem);

        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        edtResult = findViewById(R.id.edtResult);

        edtValor1.requestFocus();

        edtValor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(), TecladoNumerico.class);
                i.putExtra("valor", edtValor1.getText().toString());
                startActivityForResult(i, 1);
            }
        });

        edtValor1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    i = new Intent(getApplicationContext(), TecladoNumerico.class);
                    i.putExtra("valor", edtValor1.getText().toString());
                    startActivityForResult(i, 1);
                }
            }
        });

        edtValor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(), TecladoNumerico.class);
                i.putExtra("valor", edtValor2.getText().toString());
                startActivityForResult(i, 2);
            }
        });

        edtValor2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    i = new Intent(getApplicationContext(), TecladoNumerico.class);
                    i.putExtra("valor", edtValor2.getText().toString());
                    startActivityForResult(i, 2);
                }
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                edtValor1.setText(data.getStringExtra("numero"));
                edtValor2.requestFocus();
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                edtValor2.setText(data.getStringExtra("numero"));
            }
        }
    }
}
