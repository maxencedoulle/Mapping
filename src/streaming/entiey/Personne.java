/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entiey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Formation
 */
@Entity
public class Personne implements Serializable {
    @ManyToMany (mappedBy = "acteur")
    private List<Film> film_Interprete = new ArrayList<>();
    
    @ManyToMany (mappedBy = "realisateur")
    private List<Film> film_realise = new ArrayList<> ();
    
    @ManyToMany (mappedBy = "acteur")
    private List<Serie> serie_Interprete = new ArrayList<>();
    
    @ManyToMany (mappedBy = "realisateur")
    private List<Serie> serie_realise = new ArrayList<> ();
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entiey.Personene[ id=" + id + " ]";
    }
    
}
