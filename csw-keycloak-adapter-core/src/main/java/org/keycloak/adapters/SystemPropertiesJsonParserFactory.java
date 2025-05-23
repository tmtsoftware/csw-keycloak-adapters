/*
 * Copyright (c) 2016 Thirty Meter Telescope International Observatory
 * SPDX-License-Identifier: Apache-2.0
 */

package org.keycloak.adapters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import org.keycloak.common.util.StringPropertyReplacer;
import org.keycloak.common.util.SystemEnvProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Provides replacing of system properties for parsed values
 *
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
class SystemPropertiesJsonParserFactory extends MappingJsonFactory {

    @Override
    protected JsonParser _createParser(InputStream in, IOContext ctxt) throws IOException {
        JsonParser delegate =  super._createParser(in, ctxt);
        return new SystemPropertiesAwareJsonParser(delegate);
    }

    @Override
    protected JsonParser _createParser(Reader r, IOContext ctxt) throws IOException {
        JsonParser delegate =  super._createParser(r, ctxt);
        return new SystemPropertiesAwareJsonParser(delegate);
    }

    @Override
    protected JsonParser _createParser(char[] data, int offset, int len, IOContext ctxt, boolean recyclable) throws IOException {
        JsonParser delegate =  super._createParser(data, offset, len, ctxt, recyclable);
        return new SystemPropertiesAwareJsonParser(delegate);
    }

    @Override
    protected JsonParser _createParser(byte[] data, int offset, int len, IOContext ctxt) throws IOException {
        JsonParser delegate =  super._createParser(data, offset, len, ctxt);
        return new SystemPropertiesAwareJsonParser(delegate);
    }

    public static class SystemPropertiesAwareJsonParser extends JsonParserDelegate {

        public SystemPropertiesAwareJsonParser(JsonParser d) {
            super(d);
        }

        @Override
        public String getText() throws IOException {
            String orig = super.getText();
            return StringPropertyReplacer.replaceProperties(orig, SystemEnvProperties.UNFILTERED::getProperty);
        }
    }
}
