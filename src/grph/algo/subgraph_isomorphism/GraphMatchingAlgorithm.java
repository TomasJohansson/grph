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
 
 package grph.algo.subgraph_isomorphism;

import grph.Grph;
import grph.util.Matching;

import java.util.List;

public abstract class GraphMatchingAlgorithm
{
    public abstract List<Matching> findAllMatches(Grph g, Grph pattern);

    public Matching	 findOneMatch(Grph g, Grph pattern)
    {
	List<Matching> mappings = findAllMatches(g, pattern);

	if (mappings.isEmpty())
	{
	    return null;
	}
	else
	{
	    return mappings.get(0);
	}
    }

    public boolean hasMatches(Grph g, Grph pattern)
    {
	return !findAllMatches(g, pattern).isEmpty();
    }
}
