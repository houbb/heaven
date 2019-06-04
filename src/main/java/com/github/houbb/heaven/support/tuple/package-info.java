/**
 * 元组
 * Unit<A> (1 element)
 * Pair<A,B> (2 elements)
 * Triplet<A,B,C> (3 elements)
 * Quartet<A,B,C,D> (4 elements)
 * Quintet<A,B,C,D,E> (5 elements)
 * Sextet<A,B,C,D,E,F> (6 elements)
 * Septet<A,B,C,D,E,F,G> (7 elements)
 * Octet<A,B,C,D,E,F,G,H> (8 elements)
 * Ennead<A,B,C,D,E,F,G,H,I> (9 elements)
 * Decade<A,B,C,D,E,F,G,H,I,J> (10 elements)
 *
 * 为了避免平时代码两个属性就要建立一个对象的窘境。
 *
 * （1）此处只实现 2/3/4 这三种情况。
 * （2）因为个人觉得 1 个没有必要。5个及其以上毫无阅读性可言。
 * @since 0.1.9
 * @author binbin.hou
 */
package com.github.houbb.heaven.support.tuple;