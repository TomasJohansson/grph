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
 
 package grph.algo.clustering;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import toools.set.DefaultIntSet;
import toools.set.IntSet;

public class Clustering
{
    private final Collection<Cluster> clusters = new HashSet<Cluster>();

    public Collection<Cluster> getClusters()
    {
	return clusters;
    }

    public IntSet getClusterHeads()
    {
	IntSet heads = new DefaultIntSet();

	for (Cluster c : clusters)
	{
	    heads.add(c.getHead());
	}

	return heads;
    }

    public Cluster getLargestCluster()
    {
	Iterator<Cluster> i = clusters.iterator();
	Cluster largest = i.next();

	while (i.hasNext())
	{
	    Cluster c = i.next();

	    if (c.size() > largest.size())
	    {
		largest = c;
	    }
	}

	return largest;
    }
}
