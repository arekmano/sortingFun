package main

import "fmt"

func main() {
	array := []int{4, 7, 3, 6, 44, 744, 25, 33, 6, 6, 44}
	InsertionSort(array)
	fmt.Println(array)
}

func InsertionSort(array []int) {
	for i := 0; i < len(array); i++ {
		for j := 0; j < i; j++ {
			if array[i] < array[j] {
				Insert(array, i, j)
			}
		}
	}
}

func Insert(array []int, from int, to int) {
	tmp := array[from]
	for i := from; i > to; i-- {
		array[i] = array[i-1]
	}
	array[to] = tmp
}
