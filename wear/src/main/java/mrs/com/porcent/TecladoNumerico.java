package mrs.com.porcent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class TecladoNumerico extends Activity {

    private EditText edtNumero;
    private String numeroString = "";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_teclado_numerico);

        ImageButton btnApagar = findViewById(R.id.btnApagar);
        edtNumero = findViewById(R.id.edtNumero);
        edtNumero.setCursorVisible(false);

        if (getIntent().getExtras() != null) {
            numeroString = getIntent().getExtras().getString("valor");
            edtNumero.setText(numeroString);
        }

        btnApagar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                numeroString = "";
                edtNumero.setText("");
                return true;
            }
        });
    }

    public void digitarZero(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "0";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarUm(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "1";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarDois(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "2";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarTres(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "3";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarQuatro(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "4";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarCinco(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "5";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarSeis(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "6";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarSete(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "7";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarOito(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "8";
            edtNumero.setText(numeroString);
        }
    }

    public void digitarNove(View v) {
        if (edtNumero.getText().length() < 10) {
            numeroString = edtNumero.getText().toString() + "9";
            edtNumero.setText(numeroString);
        }
    }


    public void digitarPonto(View v) {
        if ((edtNumero.getText().length() < 9) && (!edtNumero.getText().toString().contains("."))) {
            numeroString = edtNumero.getText().toString() + ".";
            edtNumero.setText(numeroString);
        }
    }

    public void apagar(View v) {
        numeroString = edtNumero.getText().toString();
        if (numeroString.length() > 0) {
            edtNumero.setText(numeroString.substring(0, numeroString.length() - 1));
            edtNumero.setSelection(edtNumero.getText().length());

            numeroString = edtNumero.getText().toString();
        }
    }

    public void confirmar(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("numero", numeroString);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
