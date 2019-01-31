
package com.posidex.lifeasia.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransactionDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Data">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MergeClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="RetainedClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "data"
})
@XmlRootElement(name = "ClientMergeESBResponse")
public class ClientMergeESBResponse {

    @XmlElement(name = "Header", required = true)
    protected ClientMergeESBResponse.Header header;
    @XmlElement(name = "Data", required = true)
    protected ClientMergeESBResponse.Data data;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link ClientMergeESBResponse.Header }
     *     
     */
    public ClientMergeESBResponse.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientMergeESBResponse.Header }
     *     
     */
    public void setHeader(ClientMergeESBResponse.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link ClientMergeESBResponse.Data }
     *     
     */
    public ClientMergeESBResponse.Data getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientMergeESBResponse.Data }
     *     
     */
    public void setData(ClientMergeESBResponse.Data value) {
        this.data = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MergeClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="RetainedClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "policyNumber",
        "mergeClientNumber",
        "retainedClientNumber",
        "flag",
        "errorCode",
        "errorDescription"
    })
    public static class Data {

        @XmlElement(name = "PolicyNumber", required = true)
        protected String policyNumber;
        @XmlElement(name = "MergeClientNumber", required = true)
        protected String mergeClientNumber;
        @XmlElement(name = "RetainedClientNumber", required = true)
        protected String retainedClientNumber;
        @XmlElement(name = "Flag", required = true)
        protected String flag;
        @XmlElement(name = "ErrorCode", required = true)
        protected String errorCode;
        @XmlElement(name = "ErrorDescription", required = true)
        protected String errorDescription;

        /**
         * Gets the value of the policyNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPolicyNumber() {
            return policyNumber;
        }

        /**
         * Sets the value of the policyNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPolicyNumber(String value) {
            this.policyNumber = value;
        }

        /**
         * Gets the value of the mergeClientNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMergeClientNumber() {
            return mergeClientNumber;
        }

        /**
         * Sets the value of the mergeClientNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMergeClientNumber(String value) {
            this.mergeClientNumber = value;
        }

        /**
         * Gets the value of the retainedClientNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRetainedClientNumber() {
            return retainedClientNumber;
        }

        /**
         * Sets the value of the retainedClientNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRetainedClientNumber(String value) {
            this.retainedClientNumber = value;
        }

        /**
         * Gets the value of the flag property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlag() {
            return flag;
        }

        /**
         * Sets the value of the flag property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlag(String value) {
            this.flag = value;
        }

        /**
         * Gets the value of the errorCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getErrorCode() {
            return errorCode;
        }

        /**
         * Sets the value of the errorCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setErrorCode(String value) {
            this.errorCode = value;
        }

        /**
         * Gets the value of the errorDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getErrorDescription() {
            return errorDescription;
        }

        /**
         * Sets the value of the errorDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setErrorDescription(String value) {
            this.errorDescription = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransactionDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "source",
        "destination",
        "transactionID",
        "transactionType",
        "transactionDT"
    })
    public static class Header {

        @XmlElement(name = "Source", required = true)
        protected String source;
        @XmlElement(name = "Destination", required = true)
        protected String destination;
        @XmlElement(name = "TransactionID", required = true)
        protected String transactionID;
        @XmlElement(name = "TransactionType", required = true)
        protected String transactionType;
        @XmlElement(name = "TransactionDT", required = true)
        protected String transactionDT;

        /**
         * Gets the value of the source property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the destination property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestination() {
            return destination;
        }

        /**
         * Sets the value of the destination property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestination(String value) {
            this.destination = value;
        }

        /**
         * Gets the value of the transactionID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionID() {
            return transactionID;
        }

        /**
         * Sets the value of the transactionID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionID(String value) {
            this.transactionID = value;
        }

        /**
         * Gets the value of the transactionType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionType() {
            return transactionType;
        }

        /**
         * Sets the value of the transactionType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionType(String value) {
            this.transactionType = value;
        }

        /**
         * Gets the value of the transactionDT property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionDT() {
            return transactionDT;
        }

        /**
         * Sets the value of the transactionDT property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionDT(String value) {
            this.transactionDT = value;
        }

    }

}
