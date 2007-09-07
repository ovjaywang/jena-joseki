/**
 * SparqlChoice_type0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:58 LKT)
 */
package org.w3.www._2005.sparql_results;


/**
 *  SparqlChoice_type0 bean class
 */
public class SparqlChoice_type0 implements org.apache.axis2.databinding.ADBBean {
    /**
     * field for Results
     */
    protected org.w3.www._2005.sparql_results.Results_type0 localResults;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localResultsTracker = false;

    /**
     * field for _boolean
     */
    protected boolean local_boolean;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean local_booleanTracker = false;

    /* This type was generated from the piece of schema that had
       name = sparqlChoice_type0
       Namespace URI = http://www.w3.org/2005/sparql-results#
       Namespace Prefix = ns1
     */
    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://www.w3.org/2005/sparql-results#")) {
            return "ns1";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Whenever a new property is set ensure all others are unset
     *  There can be only one choice and the last one wins
     */
    private void clearAllSettingTrackers() {
        localResultsTracker = false;

        local_booleanTracker = false;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2005.sparql_results.Results_type0
     */
    public org.w3.www._2005.sparql_results.Results_type0 getResults() {
        return localResults;
    }

    /**
     * Auto generated setter method
     * @param param Results
     */
    public void setResults(org.w3.www._2005.sparql_results.Results_type0 param) {
        clearAllSettingTrackers();

        if (param != null) {
            //update the setting tracker
            localResultsTracker = true;
        } else {
            localResultsTracker = false;
        }

        this.localResults = param;
    }

    /**
     * Auto generated getter method
     * @return boolean
     */
    public boolean get_boolean() {
        return local_boolean;
    }

    /**
     * Auto generated setter method
     * @param param _boolean
     */
    public void set_boolean(boolean param) {
        clearAllSettingTrackers();

        // setting primitive attribute tracker to true
        if (false) {
            local_booleanTracker = false;
        } else {
            local_booleanTracker = true;
        }

        this.local_boolean = param;
    }

    /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
    public static boolean isReaderMTOMAware(
        javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try {
            isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        } catch (java.lang.IllegalArgumentException e) {
            isReaderMTOMAware = false;
        }

        return isReaderMTOMAware;
    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {
        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                parentQName) {
                public void serialize(
                    org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                    throws javax.xml.stream.XMLStreamException {
                    SparqlChoice_type0.this.serialize(parentQName, factory,
                        xmlWriter);
                }
            };

        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName,
            factory, dataSource);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory,
        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        java.lang.String prefix = null;
        java.lang.String namespace = null;

        if (localResultsTracker) {
            if (localResults == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "results cannot be null!!");
            }

            localResults.serialize(new javax.xml.namespace.QName(
                    "http://www.w3.org/2005/sparql-results#", "results"),
                factory, xmlWriter);
        }

        if (local_booleanTracker) {
            namespace = "http://www.w3.org/2005/sparql-results#";

            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "boolean", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                } else {
                    xmlWriter.writeStartElement(namespace, "boolean");
                }
            } else {
                xmlWriter.writeStartElement("boolean");
            }

            if (false) {
                throw new org.apache.axis2.databinding.ADBException(
                    "boolean cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        local_boolean));
            }

            xmlWriter.writeEndElement();
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }

        java.lang.String attributeValue;

        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     *  method to handle Qnames
     */
    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" +
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }

                namespaceURI = qnames[i].getNamespaceURI();

                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);

                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qnames[i]));
                }
            }

            xmlWriter.writeCharacters(stringToWrite.toString());
        }
    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }

            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     *
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {
        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localResultsTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2005/sparql-results#", "results"));

            if (localResults == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "results cannot be null!!");
            }

            elementList.add(localResults);
        }

        if (local_booleanTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2005/sparql-results#", "boolean"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    local_boolean));
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
            elementList.toArray(), attribList.toArray());
    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory {
        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         *                If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static SparqlChoice_type0 parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            SparqlChoice_type0 object = new SparqlChoice_type0();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"sparqlChoice_type0".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (SparqlChoice_type0) org.w3.www._2005.sparql_results.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://www.w3.org/2005/sparql-results#", "results").equals(
                            reader.getName())) {
                    object.setResults(org.w3.www._2005.sparql_results.Results_type0.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else if (reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://www.w3.org/2005/sparql-results#", "boolean").equals(
                            reader.getName())) {
                    java.lang.String content = reader.getElementText();

                    object.set_boolean(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(
                            content));

                    reader.next();
                } // End of if for expected property start element
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }
    } //end of factory class
}
