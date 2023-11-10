
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para buscarPorCodigoONombre complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="buscarPorCodigoONombre"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="buscar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarPorCodigoONombre", propOrder = {
    "buscar"
})
public class BuscarPorCodigoONombre {

    protected String buscar;

    /**
     * Obtiene el valor de la propiedad buscar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuscar() {
        return buscar;
    }

    /**
     * Define el valor de la propiedad buscar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuscar(String value) {
        this.buscar = value;
    }

}
