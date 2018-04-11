/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entiey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Formation
 */
@Entity
public class Serie implements Serializable {
    
    @ManyToMany 
    @JoinTable (name = "acteur_serie")
    private List<Personne> acteur = new ArrayList<>();
    
    @ManyToMany
    @JoinTable (name = "realisteur_serie")
    private List<Personne> realisateur = new ArrayList<> ();
    
    @Column (nullable = false, length = 32, unique = true)
    private String Titre;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    
    @ManyToOne
    @JoinColumn (name = "genre_id")
    private Genre genre;
    
    @ManyToOne
    @JoinColumn (name = "pays_id")
    private Pays pays;
    
    @OneToMany(mappedBy = "serie")
    private List<Saison> saisons = new ArrayList<> (); 
    
    @Column (length = 4000)
    private String Synospsis;
    

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
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entiey.Serie[ id=" + id + " ]";
    }
    
}
