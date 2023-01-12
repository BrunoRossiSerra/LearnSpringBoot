package med.voll.api.endereco;


import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.cidade = endereco.cidade();
        this.cep = endereco.cidade();
        this.uf = endereco.uf();
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.complemento = endereco.complemento();

    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }

    }
}
