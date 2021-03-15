package br.com.projetoweb.domain;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class GenericDomain implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    
    public long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final long codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return String.format("%s[codigo=%d]", this.getClass().getSimpleName(), this.getCodigo());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + (int)(this.codigo ^ this.codigo >>> 32);
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final GenericDomain other = (GenericDomain)obj;
        return this.codigo == other.codigo;
    }
}