/*
 * (C) Copyright 2009-2013 CNRS.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:

    Luc Hogie (CNRS, I3S laboratory, University of Nice-Sophia Antipolis) 
    Aurelien Lancin (Coati research team, Inria)
    Christian Glacet (LaBRi, Bordeaux)
    David Coudert (Coati research team, Inria)
    Fabien Crequis (Coati research team, Inria)
    Grégory Morel (Coati research team, Inria)
    Issam Tahiri (Coati research team, Inria)
    Julien Fighiera (Aoste research team, Inria)
    Laurent Viennot (Gang research-team, Inria)
    Michel Syska (I3S, University of Nice-Sophia Antipolis)
    Nathann Cohen (LRI, Saclay) 
 */
 
 package grph.algo;

import grph.Grph;
import jalinopt.LP;
import jalinopt.LP.OptimizationType;
import jalinopt.Variable;
import jalinopt.Variable.TYPE;

@SuppressWarnings("serial")
public abstract class StructuredLPBasedAlgorithm<R> extends LPBasedAlgorithm<R>
{
    @Override
    protected LP getLP(Grph g)
    {
	LP p = new LP();
	setObjective(p, g);
	p.setOptimizationType(getOptimizationType());
	setConstraints(g, p);

	for (Variable variable : p.getVariables())
	{
	    variable.setType(getVariableType(variable));
	}

	return p;
    }

    protected abstract TYPE getVariableType(Variable v);

    protected abstract void setConstraints(Grph g, LP p);

    protected abstract OptimizationType getOptimizationType();

    protected abstract void setObjective(LP lp, Grph g);

}
