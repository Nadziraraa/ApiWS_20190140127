/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.jajan.c.ws.jajan.ass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "bunga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bunga.findAll", query = "SELECT b FROM Bunga b"),
    @NamedQuery(name = "Bunga.findById", query = "SELECT b FROM Bunga b WHERE b.id = :id"),
    @NamedQuery(name = "Bunga.findByNamaBunga", query = "SELECT b FROM Bunga b WHERE b.namaBunga = :namaBunga"),
    @NamedQuery(name = "Bunga.findByWarnaBunga", query = "SELECT b FROM Bunga b WHERE b.warnaBunga = :warnaBunga"),
    @NamedQuery(name = "Bunga.findByJenisBunga", query = "SELECT b FROM Bunga b WHERE b.jenisBunga = :jenisBunga")})
public class Bunga implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Object findById(String idproduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Bunga save(Bunga c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama_bunga")
    private String namaBunga;
    @Basic(optional = false)
    @Column(name = "warna_bunga")
    private String warnaBunga;
    @Basic(optional = false)
    @Column(name = "jenis_bunga")
    private String jenisBunga;

    public Bunga() {
    }

    public Bunga(Integer id) {
        this.id = id;
    }

    public Bunga(Integer id, String namaBunga, String warnaBunga, String jenisBunga) {
        this.id = id;
        this.namaBunga = namaBunga;
        this.warnaBunga = warnaBunga;
        this.jenisBunga = jenisBunga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBunga() {
        return namaBunga;
    }

    public void setNamaBunga(String namaBunga) {
        this.namaBunga = namaBunga;
    }

    public String getWarnaBunga() {
        return warnaBunga;
    }

    public void setWarnaBunga(String warnaBunga) {
        this.warnaBunga = warnaBunga;
    }

    public String getJenisBunga() {
        return jenisBunga;
    }

    public void setJenisBunga(String jenisBunga) {
        this.jenisBunga = jenisBunga;
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
        if (!(object instanceof Bunga)) {
            return false;
        }
        Bunga other = (Bunga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.jajan.c.ws.jajan.ass.Bunga[ id=" + id + " ]";
    }
    
}
