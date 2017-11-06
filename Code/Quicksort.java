int i = l, j = h;
int p = num[(h + l) / 2];
while (i <= j) {
  while (num[i] < p) i++;
  while (num[j] > p) j--;
  if (i <= j) {
    swap(i, j);
    i++; j--;
  }
}
if (l < j)
  quicksort(l, j);
if (i < h)
  quicksort(i, h);
