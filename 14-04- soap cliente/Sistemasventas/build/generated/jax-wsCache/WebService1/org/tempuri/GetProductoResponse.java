
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getProductoResult" type="{http://tempuri.org/}Producto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getProductoResult"
})
@XmlRootElement(name = "getProductoResponse")
public class GetProductoResponse {

    protected Producto getProductoResult;

    /**
     * Obtiene el valor de la propiedad getProductoResult.
     * 
     * @return
     *     possible object is
     *     {@link Producto }
     *     
     */
    public Producto getGetProductoResult() {
        return getProductoResult;
    }

    /**
     * Define el valor de la propiedad getProductoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Producto }
     *     
     */
    public void setGetProductoResult(Producto value) {
        this.getProductoResult = value;
    }

}
