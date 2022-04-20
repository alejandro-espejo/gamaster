package br.edu.gama.gamaster.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CC")
@Getter
@Setter
public class ContaCorrente extends Conta {

}
