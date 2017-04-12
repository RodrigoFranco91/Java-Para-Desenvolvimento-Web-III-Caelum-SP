package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.format.annotation.DateTimeFormat;


/* @Entity é para ser mapeada pelo ORM (JPA-Hibernate). 
Em cima dos atributos coloca-se as propriedades das colunas do banco de dados. O nome da tabela e da coluna criada sera igual da classe, podemos mudar
com as anotacoes @table e @column */

@Entity
@Table(name="TesteAlteraNomeDaTabela")
public class Tarefa {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull @Size(min=5)
	private String descricao;
	
	@Column(name ="TesteAlteraNomeDaColuna")
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
