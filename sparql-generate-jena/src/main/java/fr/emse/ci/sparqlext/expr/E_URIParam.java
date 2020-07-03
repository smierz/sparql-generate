/*
 * Copyright 2020 MINES Saint-Étienne
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
package fr.emse.ci.sparqlext.expr;

import org.apache.jena.sparql.expr.E_StrEncodeForURI;
import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.expr.ExprFunction1;
import org.apache.jena.sparql.expr.NodeValue;

/**
 * Marker class used for expressions embedded in extended IRIs
 * {@link fr.emse.ci.sparqlext.Node_ExtendedURI}
 *
 * @author Maxime Lefrançois
 */
public class E_URIParam extends ExprFunction1 {

    private static final String symbol = "e_uriparam";

    public E_URIParam(Expr expr) {
        super(expr, symbol);
    }

    @Override
    public NodeValue eval(NodeValue v) {
        return (new E_StrEncodeForURI(expr)).eval(v);
    }

    @Override
    public Expr copy(Expr expr) {
        return new E_URIParam(expr);
    }
}