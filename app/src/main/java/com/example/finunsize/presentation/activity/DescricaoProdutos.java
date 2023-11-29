package com.example.finunsize.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finunsize.R;

import java.time.format.DateTimeFormatter;

import persistence.models.ProductModel;

public class DescricaoProdutos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descricao_prod);

        Intent intent = getIntent();
        if (intent.hasExtra("selectedProduct")) {
            ProductModel selectedProduct = (ProductModel) intent.getSerializableExtra("selectedProduct");

            // Agora você pode usar selectedProduct para preencher os campos ou fazer qualquer outra coisa
            preencherCamposDescricao(selectedProduct);
        }
    }

    public void preencherCamposDescricao(ProductModel product) {

        // Obtenha referências para os TextViews do layout
        TextView nameText = findViewById(R.id.productName);
        TextView descricaoText = findViewById(R.id.DescicaoText);
        TextView marcaText = findViewById(R.id.MarcaText);
        TextView validityText = findViewById(R.id.validityText);
        TextView qtdText = findViewById(R.id.qtdText);
        TextView precoVar = findViewById(R.id.PrecoVar);
        TextView precoAta = findViewById(R.id.PrecoAta);
        TextView fornecedorText = findViewById(R.id.FornecedorText);

        // Preencha os campos com os dados do produto
        if (nameText != null && descricaoText != null && marcaText != null && validityText != null &&
                qtdText != null && precoVar != null && precoAta != null && fornecedorText != null) {

            // Preencha os campos com os dados do produto
            nameText.setText(product.getNome());
            descricaoText.setText(product.getDescricao());
            marcaText.setText(product.getInformacoes().getMarca());
            validityText.setText(product.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            qtdText.setText(String.valueOf(product.getQuantidade()));
            precoVar.setText("R$ " + product.getVarejo().toString());
            precoAta.setText("R$ " + product.getAtacado().toString());
            fornecedorText.setText(product.getFornecedor().getNome());
        }
    }


    public void OpenProdutos (View view) {
        MainActivity.redirect(this, Produtos.class);
    }
}
