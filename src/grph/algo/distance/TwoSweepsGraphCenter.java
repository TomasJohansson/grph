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

package grph.algo.distance;

import grph.Grph;
import grph.GrphAlgorithm;
import grph.algo.search.SearchResult;
import grph.in_memory.InMemoryGrph;

import com.carrotsearch.hppc.cursors.IntCursor;

public class TwoSweepsGraphCenter extends GrphAlgorithm<Integer>
{
	@Override
	public Integer compute(Grph g)
	{
		SearchResult r = g.bfs(g.bfs(0).farestVertex());
		return r.visitOrder.get(r.visitOrder.size() / 2);
	}

	public static void main(String[] args)
	{
		Grph g = new InMemoryGrph();
		// g.rnws(50, 3, 0.1);
		g.grid(10, 10);
		int center = new TwoSweepsGraphCenter().compute(g);
		g.highlightVertex(center, 5);

		for (IntCursor c : g.getVertices())
		{
			g.getVertexLabelProperty().setValue(c.value, "" + g.getEccentricity(c.value, null));
		}

		g.display();

	}

}
