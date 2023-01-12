package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;


import java.io.Serializable;
import java.util.UUID;

@Table(name = "medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    private String telefone_contato;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.telefone_contato = dados.telefone_contato();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
    }

    public void atualziarInformacoes(DadosAtualizaMedico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null ){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
