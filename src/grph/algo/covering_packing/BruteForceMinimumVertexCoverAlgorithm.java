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

package grph.algo.covering_packing;

import grph.Grph;
import grph.GrphAlgorithm;
import grph.in_memory.InMemoryGrph;
import toools.set.DefaultIntSet;
import toools.set.IntSet;
import toools.set.IntSets;

/**
 * 
 * @author Gregory Morel, Vincent Levorato, Jean-Francois Lalande
 */

@SuppressWarnings("serial")
public class BruteForceMinimumVertexCoverAlgorithm extends GrphAlgorithm<IntSet>
{

	@Override
	public IntSet compute(Grph g)
	{
		int[] items = g.getVertices().toIntArray();

		int[] tab;

		for (int k = 1; k <= items.length; k++)
		{
			tab = new int[k];
			if (kcomb(items, 0, k, tab, g))
			{
				return IntSets.from(tab);
			}
		}

		return null;
	}

	private boolean kcomb(int[] items, int n, int k, int[] arr, Grph g)
	{
		if (k == 0)
		{
			IntSet s = new DefaultIntSet();
			s.addAll(arr);
			if (g.isVertexCover(s))
				return true;
		}
		else
		{
			for (int i = n; i <= items.length - k; i++)
			{
				arr[arr.length - k] = items[i];
				if (kcomb(items, i + 1, k - 1, arr, g))
				{
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		Grph g = new InMemoryGrph();
		g.grid(5, 5);
		IntSet r = new BruteForceMinimumVertexCoverAlgorithm().compute(g);
		System.out.println(r);
	}
}
