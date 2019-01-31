
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
 *                   &lt;element name="TransactionDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                   &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MergeClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="RetainedClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SourceClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "ClientMergeESBRequest", namespace = "http://KLI.ESB.LA.ClientMerge.Schemas.ClientMerge_ESB_Req")
public class ClientMergeESBRequest {

    @XmlElement(name = "Header", required = true)
    protected ClientMergeESBRequest.Header header;
    @XmlElement(name = "Data", required = true)
    protected ClientMergeESBRequest.Data data;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link ClientMergeESBRequest.Header }
     *     
     */
    public ClientMergeESBRequest.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientMergeESBRequest.Header }
     *     
     */
    public void setHeader(ClientMergeESBRequest.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link ClientMergeESBRequest.Data }
     *     
     */
    public ClientMergeESBRequest.Data getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientMergeESBRequest.Data }
     *     
     */
    public void setData(ClientMergeESBRequest.Data value) {
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
     *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MergeClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="RetainedClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SourceClientNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "action",
        "policyNumber",
        "mergeClientNumber",
        "retainedClientNumber",
        "sourceClientNumber"
    })
    public static class Data {

        @Override
		public String toString() {
			return "Data [action=" + action + ", policyNumber=" + policyNumber + ", mergeClientNumber="
					+ mergeClientNumber + ", retainedClientNumber=" + retainedClientNumber + ", sourceClientNumber="
					+ sourceClientNumber + "]";
		}

		@XmlElement(name = "Action", required = true)
        protected String action;
        @XmlElement(name = "PolicyNumber", required = true)
        protected String policyNumber;
        @XmlElement(name = "MergeClientNumber", required = true)
        protected String mergeClientNumber;
        @XmlElement(name = "RetainedClientNumber", required = true)
        protected String retainedClientNumber;
        @XmlElement(name = "SourceClientNumber", required = true)
        protected String sourceClientNumber;

        /**
         * Gets the value of the action property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAction() {
            return action;
        }

        /**
         * Sets the value of the action property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAction(String value) {
            this.action = value;
        }

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
         * Gets the value of the sourceClientNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceClientNumber() {
            return sourceClientNumber;
        }

        /**
         * Sets the value of the sourceClientNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceClientNumber(String value) {
            this.sourceClientNumber = value;
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
     *         &lt;element name="TransactionDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "transactionDT",
        "transactionType"
    })
    public static class Header {

        @Override
		public String toString() {
			return "Header [source=" + source + ", destination=" + destination + ", transactionDT=" + transactionDT
					+ ", transactionType=" + transactionType + "]";
		}

		@XmlElement(name = "Source", required = true)
        protected String source;
        @XmlElement(name = "Destination", required = true)
        protected String destination;
        @XmlElement(name = "TransactionDT", required = true)
        protected String transactionDT;
        @XmlElement(name = "TransactionType", required = true)
        protected String transactionType;

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

    }

}
