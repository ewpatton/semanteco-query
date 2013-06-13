package edu.rpi.tw.escience.semanteco.query.impl;

import org.junit.Test;

import edu.rpi.tw.escience.semanteco.query.impl.VariableImpl;
import edu.rpi.tw.escience.semanteco.query.Query;
import edu.rpi.tw.escience.semanteco.query.Variable;

import junit.framework.TestCase;

public class VariableTest extends TestCase {
	@Test
	public void testConstructor() {
		new VariableImpl(Query.VAR_NS+"x");
	}

	@Test
	public void testConstructorException() {
		try {
			new VariableImpl("http://example.com/failure");
			fail();
		} catch(IllegalArgumentException e) {
		}
	}

	@Test
	public void testGetUri() {
		VariableImpl x = new VariableImpl(Query.VAR_NS+"x");
		assertEquals(Query.VAR_NS+"x", x.getUri());
	}

	@Test
	public void testToString() {
		assertEquals("?x", (new VariableImpl(Query.VAR_NS+"x")).toString());
	}

	@Test
	public void testEquals() {
		VariableImpl x = new VariableImpl(Query.VAR_NS+"x");
		VariableImpl y = new VariableImpl(Query.VAR_NS+"y");
		VariableImpl z = new VariableImpl(Query.VAR_NS+"x");
		VariableImpl nv = new VariableImpl(null);
		VariableImpl nv2 = new VariableImpl(null);
		assertTrue(x.equals(x));
		assertFalse(x.equals(null));
		assertFalse(x.equals(new Object()));
		assertTrue(x.equals(z));
		assertFalse(x.equals(y));
		assertFalse(x.equals(nv));
		assertFalse(nv.equals(x));
		assertTrue(nv.equals(nv2));
	}

	@Test
	public void testHashCode() {
		Variable x = new VariableImpl(Query.VAR_NS+"x");
		assertEquals(31+(Query.VAR_NS+"x").hashCode(), x.hashCode());
		x = new VariableImpl(null);
		assertEquals(31, x.hashCode());
		assertEquals(x.hashCode(), x.hashCode());
	}

	@Test
	public void testGetName() {
		Variable x = new VariableImpl(Query.VAR_NS+"x");
		assertEquals("x", x.getName());
	}
}
