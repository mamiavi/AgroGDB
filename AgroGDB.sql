PGDMP     $    4                x           agroGDB    12.3    12.3 -    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17644    agroGDB    DATABASE     �   CREATE DATABASE "agroGDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "agroGDB";
                postgres    false                        3079    17645    postgis 	   EXTENSION     ;   CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;
    DROP EXTENSION postgis;
                   false            �           0    0    EXTENSION postgis    COMMENT     g   COMMENT ON EXTENSION postgis IS 'PostGIS geometry, geography, and raster spatial types and functions';
                        false    2            �            1259    18691    BALSAS    TABLE     J  CREATE TABLE public."BALSAS" (
    "ID" integer NOT NULL,
    "Nombre" text,
    "Year" integer,
    "Capacidad" integer,
    "Estado" text,
    "Materiales" text,
    "Filtraciones" boolean,
    "Problemas Funcionamiento" text,
    "Funcion" text,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Polygon,4326)
);
    DROP TABLE public."BALSAS";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    18689    BALSAS_ID_seq    SEQUENCE     �   ALTER TABLE public."BALSAS" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."BALSAS_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            �            1259    18703 	   CABEZALES    TABLE     �   CREATE TABLE public."CABEZALES" (
    "ID" integer NOT NULL,
    "Nombre" text,
    "Dimensiones" integer,
    "Tipo Construccion" text,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Point,4326)
);
    DROP TABLE public."CABEZALES";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    18701    CABEZALES_ID_seq    SEQUENCE     �   ALTER TABLE public."CABEZALES" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."CABEZALES_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    18654    EERR    TABLE     �   CREATE TABLE public."EERR" (
    "CODIGO" integer NOT NULL,
    "DENOMINACION" text NOT NULL,
    "DIRECCION" text,
    "TELEFONO" integer
);
    DROP TABLE public."EERR";
       public         heap    postgres    false            �            1259    18657    EERR_CODIGO_seq    SEQUENCE     �   ALTER TABLE public."EERR" ALTER COLUMN "CODIGO" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."EERR_CODIGO_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    208            �            1259    18667    FICHA_PERSONAL    TABLE     r   CREATE TABLE public."FICHA_PERSONAL" (
    "NOMBRE" text,
    "POSICION" text,
    "TELEFONO" integer NOT NULL
);
 $   DROP TABLE public."FICHA_PERSONAL";
       public         heap    postgres    false            �            1259    18713    IMPULSIONES    TABLE     U  CREATE TABLE public."IMPULSIONES" (
    "ID" integer NOT NULL,
    "Nombre" text,
    "Year" integer,
    "Tipo Tarifa Electrica" text,
    "Potencia Contratada" integer,
    "Tipo de Bomba" text,
    "Caudal Nominal" integer,
    "Altura Manométrica" integer,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Point,4326)
);
 !   DROP TABLE public."IMPULSIONES";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    18711    IMPULSIONES_ID_seq    SEQUENCE     �   ALTER TABLE public."IMPULSIONES" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."IMPULSIONES_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    18675    OTROS    TABLE     �   CREATE TABLE public."OTROS" (
    "ID" integer NOT NULL,
    "Nombre" text,
    "Year" integer,
    "Descripcion" text,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Point,4326)
);
    DROP TABLE public."OTROS";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    26867    OTROS_ID_seq    SEQUENCE     �   ALTER TABLE public."OTROS" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."OTROS_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �            1259    18723    PARCELAS    TABLE     �   CREATE TABLE public."PARCELAS" (
    "ID " integer NOT NULL,
    "Tipo Cultivo" text,
    "Sistema de Riego" text,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Polygon,4326)
);
    DROP TABLE public."PARCELAS";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    18721    PARCELAS_ID _seq    SEQUENCE     �   ALTER TABLE public."PARCELAS" ALTER COLUMN "ID " ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."PARCELAS_ID _seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    18733    POZOS    TABLE       CREATE TABLE public."POZOS" (
    "ID" integer NOT NULL,
    "Nombre" text,
    "Year" integer,
    "Codigo concesion administrativa" integer,
    "Profundidad sondeo" double precision,
    "Diametro sondeo" double precision,
    "Nivel Piezometrico" double precision,
    "Tipo Tarifa Electrica" text,
    "Potencia Contratada" integer,
    "Tipo Bomba" text,
    "Caudal Nominal" integer,
    "Altura manometrica" integer,
    "Variador" boolean,
    num_telf integer,
    "EERR" text,
    geom public.geometry(Point,4326)
);
    DROP TABLE public."POZOS";
       public         heap    postgres    false    2    2    2    2    2    2    2    2            �            1259    26877    POZOS_ID_seq    SEQUENCE     �   ALTER TABLE public."POZOS" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."POZOS_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �          0    18691    BALSAS 
   TABLE DATA           �   COPY public."BALSAS" ("ID", "Nombre", "Year", "Capacidad", "Estado", "Materiales", "Filtraciones", "Problemas Funcionamiento", "Funcion", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    213   :6       �          0    18703 	   CABEZALES 
   TABLE DATA           q   COPY public."CABEZALES" ("ID", "Nombre", "Dimensiones", "Tipo Construccion", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    215   7       �          0    18654    EERR 
   TABLE DATA           S   COPY public."EERR" ("CODIGO", "DENOMINACION", "DIRECCION", "TELEFONO") FROM stdin;
    public          postgres    false    208   �7       �          0    18667    FICHA_PERSONAL 
   TABLE DATA           L   COPY public."FICHA_PERSONAL" ("NOMBRE", "POSICION", "TELEFONO") FROM stdin;
    public          postgres    false    210   �7       �          0    18713    IMPULSIONES 
   TABLE DATA           �   COPY public."IMPULSIONES" ("ID", "Nombre", "Year", "Tipo Tarifa Electrica", "Potencia Contratada", "Tipo de Bomba", "Caudal Nominal", "Altura Manométrica", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    217   �7       �          0    18675    OTROS 
   TABLE DATA           `   COPY public."OTROS" ("ID", "Nombre", "Year", "Descripcion", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    211   R8       �          0    18723    PARCELAS 
   TABLE DATA           g   COPY public."PARCELAS" ("ID ", "Tipo Cultivo", "Sistema de Riego", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    219   o8       �          0    18733    POZOS 
   TABLE DATA           %  COPY public."POZOS" ("ID", "Nombre", "Year", "Codigo concesion administrativa", "Profundidad sondeo", "Diametro sondeo", "Nivel Piezometrico", "Tipo Tarifa Electrica", "Potencia Contratada", "Tipo Bomba", "Caudal Nominal", "Altura manometrica", "Variador", num_telf, "EERR", geom) FROM stdin;
    public          postgres    false    220   Q9                 0    17950    spatial_ref_sys 
   TABLE DATA           X   COPY public.spatial_ref_sys (srid, auth_name, auth_srid, srtext, proj4text) FROM stdin;
    public          postgres    false    204   	:       �           0    0    BALSAS_ID_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."BALSAS_ID_seq"', 4, true);
          public          postgres    false    212            �           0    0    CABEZALES_ID_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."CABEZALES_ID_seq"', 4, true);
          public          postgres    false    214            �           0    0    EERR_CODIGO_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."EERR_CODIGO_seq"', 18, true);
          public          postgres    false    209            �           0    0    IMPULSIONES_ID_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."IMPULSIONES_ID_seq"', 1, true);
          public          postgres    false    216            �           0    0    OTROS_ID_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."OTROS_ID_seq"', 3, true);
          public          postgres    false    221            �           0    0    PARCELAS_ID _seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."PARCELAS_ID _seq"', 12, true);
          public          postgres    false    218            �           0    0    POZOS_ID_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."POZOS_ID_seq"', 4, true);
          public          postgres    false    222                       2606    18700    BALSAS BALSAS_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."BALSAS"
    ADD CONSTRAINT "BALSAS_pkey" PRIMARY KEY ("ID");
 @   ALTER TABLE ONLY public."BALSAS" DROP CONSTRAINT "BALSAS_pkey";
       public            postgres    false    213                       2606    18710    CABEZALES CABEZALES_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."CABEZALES"
    ADD CONSTRAINT "CABEZALES_pkey" PRIMARY KEY ("ID");
 F   ALTER TABLE ONLY public."CABEZALES" DROP CONSTRAINT "CABEZALES_pkey";
       public            postgres    false    215                       2606    18666    EERR EERR_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."EERR"
    ADD CONSTRAINT "EERR_pkey" PRIMARY KEY ("CODIGO");
 <   ALTER TABLE ONLY public."EERR" DROP CONSTRAINT "EERR_pkey";
       public            postgres    false    208                       2606    18674 "   FICHA_PERSONAL FICHA_PERSONAL_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."FICHA_PERSONAL"
    ADD CONSTRAINT "FICHA_PERSONAL_pkey" PRIMARY KEY ("TELEFONO");
 P   ALTER TABLE ONLY public."FICHA_PERSONAL" DROP CONSTRAINT "FICHA_PERSONAL_pkey";
       public            postgres    false    210                       2606    18720    IMPULSIONES IMPULSIONES_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."IMPULSIONES"
    ADD CONSTRAINT "IMPULSIONES_pkey" PRIMARY KEY ("ID");
 J   ALTER TABLE ONLY public."IMPULSIONES" DROP CONSTRAINT "IMPULSIONES_pkey";
       public            postgres    false    217            
           2606    26876    OTROS OTROS_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."OTROS"
    ADD CONSTRAINT "OTROS_pkey" PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public."OTROS" DROP CONSTRAINT "OTROS_pkey";
       public            postgres    false    211                       2606    18730    PARCELAS PARCELAS_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public."PARCELAS"
    ADD CONSTRAINT "PARCELAS_pkey" PRIMARY KEY ("ID ");
 D   ALTER TABLE ONLY public."PARCELAS" DROP CONSTRAINT "PARCELAS_pkey";
       public            postgres    false    219                       2606    26892    POZOS POZOS_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."POZOS"
    ADD CONSTRAINT "POZOS_pkey" PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public."POZOS" DROP CONSTRAINT "POZOS_pkey";
       public            postgres    false    220            �   �   x���Mj1���)�E����������q���s��#�'t�>2|�	���T��㥾�	����yL�g����s-���~�ù��{�����@�b ��<�>|�8��$A� d�3�21�MN�	Q�g�&�'p�=
E����� %ň�;�lUQ�6��n��(�=��y�d��aY �sk̙r��C��?����i�u�X      �   l   x�3�tNLJ�J�QJMO�+I-VHIUp:��$�(�3��a��9?�4/3%1��C #W30��������������������������������Ā+F��� 
%�      �      x������ � �      �      x������ � �      �   n   x�3���-(�)���S0��CG�0�霟[�������������W�Zb;^Y�Z��i`�@`d�jf8��9;:�:��8���;Y����:;;��p��qqq `B"C      �      x������ � �      �   �   x���=n�0�Y>ENP�������й�PE���tɍr�^����}�#��Dk^�Ο��</���x��b�����8��0N���Η���{�L�j ��!��V��0g�<����2���bB�o�SR�s��;v�E1m@CTX���rA挰�d?hd����!!+�=���^@m*R�����s)Z�����{{��5 P      �   �   x���M
�0�ur��@2I��IpSD��&�B��o�9��i���of�f3|�����Bd����u�0 ��o{#�	�c�m��>�b���k7��'$Ҥ��pḶ�(��:n|	�t���J*N�`3%�ط]�����ο��8�L����+J�AikˍT�(�o��O�            x������ � �     