/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entiey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import streaming.entiey.boutique.Produit;

/**
 *
 * @author Formation
 */
@Entity
public class Film implements Serializable {
    
    @ManyToMany
    @JoinTable (name = "Film_Acteur")
    private List<Personne> acteur = new ArrayList<>();
    
    @ManyToMany
    @JoinTable (name = "Film_Realisateur")
    private List<Personne> realisateur = new ArrayList<>();
    
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 10000)
    private String Synospsis;
    
    @OneToMany(mappedBy = "film")
    private List<Lien> liens = new ArrayList<> ();
    
    @ManyToOne
    @JoinColumn (name = "genre_id")
    private Genre genre;
    
    @ManyToOne
    @JoinColumn (name = "pays_id")
    private Pays pays;
    
    
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSortie;
    
    @Column (nullable = false, length = 32, unique = true)
    private String titre;

    public String getSynospsis() {
        return Synospsis;
    }

    public void setSynospsis(String Synospsis) {
        this.Synospsis = Synospsis;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entiey.Film[ id=" + id + " ]";
    }
    
}
