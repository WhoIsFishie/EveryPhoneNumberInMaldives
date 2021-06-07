#include<stdio.h>
#include<conio.h>
#include <string.h>
int main()
{
    int opt,numd,x,numo;
    FILE *out_file = fopen("Number_list.csv", "w");

    printf("\nEst TIME: 57 Seconds\n");
    printf("\nEst FILE SIZE: 16.2 MB\n");
    printf("\nSelect a number list to Gen\n\n1:Dhiraagu    // Gen all possible numbers\n2:Ooredoo    // Gen all possible numbers\n3:DEMO MODE // Gen 1000 numbers\n");
    scanf("%d",&opt);

    if (out_file == NULL)
    {
        printf("Error! Could not open file\n");
        scanf("press any key to exit");
    }

    switch (opt)
    {

    case 1: //generating dhiraagu list
        x=0;
        numd=6999999;
        fprintf(out_file, "Name,Number\n");
        while (numd <= 7999998)
        {
            numd=numd+1;
            fprintf(out_file, "+960%.0d, %.0d\n",numd,numd);
            printf("number: +960%.0d\n",numd);
            x=x+1;
        }

        fprintf(out_file, "END OF GEN\n");
        printf("Please wait....");
        scanf("press any key to exit");

        break;

    case 2: //generating ooredoo list
        x=0;
        numo=8999999;

        fprintf(out_file, "Name,Number\n");

        while (numo <= 9999998)
        {
            numo=numo+1;
            fprintf(out_file, "+960%.0d, %.0d\n",numd,numd);
            printf("number: +960%.0d\n",numo);
            x=x+1;
        }

        fprintf(out_file, "END OF GEN\n");
        printf("Please wait....");
        scanf("press any key to exit");

        break;
    case 3: // generating demo list
        x=0;
        numo=8999999;

        fprintf(out_file, "Name,Number\n");

        while (numo <= 9000998)
        {
            numo=numo+1;
            fprintf(out_file, "+960%.0d, %.0d\n",numd,numd);
            printf("number: +960%.0d\n",numo);
            x=x+1;
        }

        fprintf(out_file, "END OF GEN\n");
        printf("Please wait....");
        scanf("press any key to exit");

        break;

    default:
        break;
    }

    printf("\n\nnumbers gen: %.0d\n",x);
}