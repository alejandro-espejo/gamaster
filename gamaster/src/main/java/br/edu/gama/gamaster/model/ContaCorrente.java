package br.edu.gama.gamaster.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
@Getter
@Setter
public class ContaCorrente extends Conta {

}
