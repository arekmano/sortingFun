#include <stdio.h>

void shiftRight(int array[], int i, int pivotIndex);
void shiftLeft(int array[], int i, int pivotIndex);
void quickSort(int array[], int size);
void quickSort_with_index(int array[], int leftIndex, int rightIndex);

int main(int argc, char const *argv[])
{
  int array[10];
  array[0] = 40;
  array[1] = 20;
  array[2] = 25;
  array[3] = 14;
  array[4] = 3;
  array[5] = 688;
  array[6] = 324;
  array[7] = 2;
  array[8] = 523;
  array[9] = 34;

  quickSort(array, 10);
  for (int i = 0; i < 10; i++)
  {
    printf("array[%d] = %d\n", i, array[i]);
  }
  return 0;
}

void shiftRight(int array[], int i, int pivotIndex)
{
  int pivot = array[pivotIndex];
  array[pivotIndex] = array[i];
  for (int j = i; j > pivotIndex+1; j--)
  {
    array[j] = array[j-1];
  }
  array[pivotIndex+1] = pivot;
}

void shiftLeft(int array[], int i, int pivotIndex)
{
  int pivot = array[pivotIndex];
  array[pivotIndex] = array[i];
  for (int j = pivotIndex - 1; j < i+1; j--)
  {
    array[j-1] = array[j];
  }
  array[pivotIndex-1] = pivot;
}


void quickSort(int array[], int size)
{
  int rightIndex = size - 1;
  int leftIndex = 0;
  quickSort_with_index(array, leftIndex, rightIndex);
}

void quickSort_with_index(int array[], int leftIndex, int rightIndex)
{
  if (leftIndex == rightIndex){
    return;
  }
  int pivotIndex = leftIndex;
  for (int i = leftIndex; i <= rightIndex; i++)
  {
    if (i == pivotIndex)
    {
      continue;
    }
    if (i > pivotIndex && array[i] < array[pivotIndex])
    {
      shiftRight(array, i, pivotIndex);
      pivotIndex = pivotIndex + 1;
    }
    else if (i < pivotIndex && array[i] >= array[pivotIndex])
    {
      shiftLeft(array, i, pivotIndex);
      pivotIndex = pivotIndex - 1;
    }
  }
  if (leftIndex != pivotIndex)
  {
    quickSort_with_index(array, leftIndex, pivotIndex);
  }
  if (rightIndex != pivotIndex)
  {
  quickSort_with_index(array, pivotIndex + 1, rightIndex);
  }
}
