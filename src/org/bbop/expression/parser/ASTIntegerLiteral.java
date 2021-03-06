/*
 * Copyright 2002-2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bbop.expression.parser;

import org.bbop.expression.JexlContext;

/**
 * represents an integer.
 * 
 * @author <a href="mailto:geirm@apache.org">Geir Magnusson Jr.</a>
 * @version $Id: ASTIntegerLiteral.java,v 1.3 2007/09/27 01:02:07 jmr39 Exp $
 */
import org.apache.log4j.*;

public class ASTIntegerLiteral extends SimpleNode {

	//initialize logger
	protected final static Logger logger = Logger.getLogger(ASTIntegerLiteral.class);
    /** literal value. */
    protected Integer val;

    /**
     * Create the node given an id.
     * 
     * @param id node id.
     */
    public ASTIntegerLiteral(int id) {
        super(id);
    }

    /**
     * Create a node with the given parser and id.
     * 
     * @param p a parser.
     * @param id node id.
     */
    public ASTIntegerLiteral(Parser p, int id) {
        super(p, id);
    }

    /** {@inheritDoc} */
    @Override
	public Object jjtAccept(ParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    /**
     * Part of reference resolution - wierd... in JSTL EL you can have foo.2
     * which is equiv to foo[2] it appears...
     *
     * @param obj the object to evaluate against.
     * @param ctx the {@link JexlContext}.
     * @throws Exception on any error.
     * @return the resulting value.
     * @see ASTArrayAccess#evaluateExpr(Object, Object)
     */
    @Override
	public Object execute(Object obj, JexlContext ctx) throws Exception {
        return ASTArrayAccess.evaluateExpr(obj, val, this);
    }

    /** {@inheritDoc} */
    @Override
	public Object value(JexlContext jc) throws Exception {
        return val;
    }
}
